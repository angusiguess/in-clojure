(ns in-clojure.core
  (:use overtone.live
        overtone.inst.sampled-piano))

(def part-one [:C5 :C5 :C5 :C5])
(def part-one-time [300 300 300 300])

(def part-two [:C4 :E4 :C4 :E4 :C4 :E4])
(def part-two-time [80 300 80 300 80 300])

(def part-three [:C4 :E4 :F4 :E4])
(def part-three-time [60 300 300 300])

(def part-four [:C5 :C5])
(def part-four-time [600 600])

(defn player
  [t speeds notes]
  (let [n (first notes)
        notes (next notes)
        t-next (+ t (first speeds))]
    (when n
      (at t
          (sampled-piano (note n)))
      (apply-at t-next #'player [t-next  (next speeds) notes]))))

(defn play-measure
  [times notes]
  (player (now) (take (count times) (cycle times))
          (take (count notes) (cycle notes))))

;(player (now) (take 4 (cycle part-four-time)) (take 4 (cycle part-four)))

(do
  (play-measure part-one-time part-one)
  (play-measure part-three-time part-three))

;(play-measure part-one-time part-one)
