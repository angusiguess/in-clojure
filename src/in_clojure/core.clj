(ns in-clojure.core
  (:use overtone.live
        overtone.inst.sampled-piano))

(def rhythm [:C5 :C5 :C5 :C5])
(def rhythm-time [1/4 1/4 1/4 1/4])

(def part-one [:C4 :E4 :C4 :E4 :C4 :E4])
(def part-one-time [1/8 1/4 1/8 1/4 1/8 1/4])

(def part-two [:C4 :E4 :F4 :E4])
(def part-two-time [1/8 1/4 1/4 1/4])

(def part-three [0 :E4 :F4 :E4])
(def part-three-time [1/8 1/8 1/4 1/4])

(def part-four [0 :E4 :F4 :G4])
(def part-four-time [1/8 1/4 1/4 1/8])

(def part-five [:E4 :F4 :G4 0])
(def part-five-time [1/4 1/4 1/8 1/8])

(def part-six [:C5 :C5])
(def part-six-time [1 1])

(def part-seven [0 0 0 0 :C4 :C4 :C4 0 0 0 0 ])
(def part-seven-time [1/4 1/4 1/4 1/8 1/16 1/16 1/8 1/8 1/4 1/4 1/4])

(def part-eight [:G4 :F4 :F4])
(def part-eight-time [1.5 1 1])

(def part-nine [:B5 :G4 :G4 0 0 0 0])
(def part-nine-time [1/16 1/16 1/8 1/4 1/4 1/4])

(defn player
  [t speeds notes]
  (let [n (first notes)
        notes (next notes)
        t-next (+ t (first speeds))]
    (when n
      (at t
          (sampled-piano (note n)))
      (apply-at t-next #'player [t-next  (next speeds) notes]))))

(def metro (metronome 48))

(defn metro-player
  [metro beat notes offsets]
  (let [n (first notes)
        notes (next notes)
        offset (first offsets)
        offsets (next offsets)
        next-offset (first (next offsets))]

    (at (metro beat) (sampled-piano (note n)))
    (apply-at (metro (+ beat offset)) #'metro-player [metro (+ beat offset) notes offsets])))

(defn play-measure
  [metro notes offsets times]
  (metro-player metro (metro)
                (take (* times (count notes)) (cycle notes))
                (take (* times (count offsets)) (cycle offsets))))

;(player (now) (take 4 (cycle part-four-time)) (take 4 (cycle part-four)))
(stop)
;(metro-player metro (metro) part-two part-two-time)
(play-measure metro part-nine part-nine-time 2)

(do
  ;(play-measure rhythm-time rhythm)
  ;(play-measure part-one-time part-one)
  ;(play-measure part-two-time part-two)
  ;(play-measure part-three-time part-three)
  ;(play-measure part-four-time part-four)
  ;(play-measure part-five-time part-five)
  ;(play-measure part-six-time part-six)
  )



;(play-measure part-one-time part-one)
