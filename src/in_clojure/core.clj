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

(def part-nine [:B5 :G4 0 0 0 0])
(def part-nine-time [1/16 1/16 1/8 1/4 1/4 1/4])

(def part-ten [:B5 :G4])
(def part-ten-time [1/16 1/16])

(def part-eleven [:F4 :G4 :B5 :G4 :B5 :G4])
(def part-eleven-time [1/16 1/16 1/16 1/16 1/16 1/16])

(def part-twelve [:F4 :G4 :B5])
(def part-twelve-time [1/4 1/4 1])

(def part-thirteen [:B5 :G4 :G4 :F4 :G4 0 :G4 :G4])
(def part-thirteen-time [1/16 1/4 3/8 1/16 1/16 1/8 3/16 1/16 3/4])

(def part-fourteen [:C5 :B4 :G4 :F#4])
(def part-fourteen-time [1 1 1 1])

(def part-fifteen [:G4 0 0 0 0])
(def part-fifteen-time [1/16 3/16 1/4 1/4 1/4])

(def part-sixteen [:G4 :A5 :C5 :B4])
(def part-sixteen-time [1/16 1/16 1/16 1/16])

(def part-seventeen [:B4 :C5 :B4 :C5 :B4 0])
(def part-seventeen-time [1/16 1/16 1/16 1/16 1/16 1/16])

(def part-eighteen [:E4 :F#4 :E4 :F4 :E4 :E4])
(def part-eighteen-time [1/16 1/16 1/16 1/16 3/8 1/16])

(def part-nineteen [0 :G5])
(def part-nineteen-time [3/8 3/8])

(def part-twenty [:E4 :F#4 :E4 :F4 :A4 :E4 :F4 :E4 :F4 :E4])
(def part-twenty-time [1/16 1/16 1/16 1/16 3/8 1/16 1/16 1/16 1/16 1/16])

(def part-twentyone [:F#4])
(def part-twentyone-time [3/4])

(def part-twentytwo [:E4 :E4 :E4 :E4 :E4 :F#4 :G4 :A4 :B4])
(def part-twentytwo-time [3/8 3/8 3/8 3/8 3/8 3/8 3/8 3/8 1/4])

(def part-twentythree [:E4 :F#4 :F4 :F4 :F4 :F4 :G4 :A4 :B4])
(def part-twentythree-time [1/8 3/8 3/8 3/8 3/8 3/8 3/8 3/8 1/8])

(def part-twentyfour [:E4 :F#4 :G4 :G4 :G4 :G4 :G4 :G4 :A4 :B4])
(def part-twentyfour-time [1/8 1/8 3/8 3/8 3/8 3/8 3/8 3/8 1/8])

(def part-twentyfive [:E4 :F#4 :G4 :A4 :A4 :A4 :A4 :A4 :B4])
(def part-twentyfive-time [1/8 1/8 1/8 3/8 3/8 3/8 3/8 3/8 3/8])

(def part-twentysix [:E4 :F#4 :G4 :A4 :B4 :B4 :B4 :B4 :B4])
(def part-twentysix-time [1/8 1/8 1/8 1/8 3/8 3/8 3/8 3/8 3/8])

(def part-twentyseven [:E4 :F#4 :E4 :F4 :G4 :E4 :G4 :F4 :E4 :F4 :E4])
(def part-twentyseven-time [1/16 1/16 1/16 1/16 1/8 1/6 1/16 1/16 1/16 1/16 1/16])

(def part-twentyeight [:E4 :F#4 :E4 :F4 :E4 :E4])
(def part-twentyeight-time [1/16 1/16 1/16 1/16 1/16 3/16 1/16])

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
    (apply-at
     (metro (+ beat offset)) #'metro-player [metro (+ beat offset) notes offsets])))

(defn play-measure
  [metro notes offsets times]
  (metro-player metro (metro)
                (take (* times (count notes)) (cycle notes))
                (take (* times (count offsets)) (cycle offsets))))

(stop)
(play-measure metro part-twentyeight part-twentyeight-time 2)
