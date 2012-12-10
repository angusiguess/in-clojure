(ns in-clojure.core
  (:use overtone.live
        overtone.inst.sampled-piano))

(definst triangle-wave [freq 2093.0 attack 0.01 sustain 0.1 release 0.4 vol 0.4]
  (* (env-gen (lin-env attack sustain release) 1 1 0 1 FREE)
     (lf-tri freq)
     vol))


(def rhythm [:C7 :C7 :C7 :C7])
(def rhythm-time [1/8 1/8 1/8 1/8])

(def part-one [:C4 :E4 :C4 :E4 :C4 :E4])
(def part-one-time [1/16 1/4 1/16 1/4 1/16 1/4])

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

(def part-twentynine [:E4 :G4 :C5])
(def part-twentynine-time [3/4 3/4 3/4])

(def part-thirty [:C5])
(def part-thirty-time [3/2])

(def part-thirtyone [:G4 :F4 :G4 :B4 :G4 :B4])
(def part-thirtyone-time [1/16 1/16 1/16 1/16 1/16 1/16])

(def part-thirtytwo [:F4 :G4 :F4 :G4 :B4 :F4 :F4 :G4])
(def part-thirtytwo-time [1/16 1/16 1/16 1/16 1/16 1/16 3/4 3/8])

(def part-thirtythree [:G4 :F4 0])
(def part-thirtythree-time [1/16 1/16 1/8])

(def part-thirtyfour [:G4 :F4])
(def part-thirtyfour-time [1/16 1/16])

(def part-thirtyfive [:F4 :G4 :B4 :G4 :B4 :G4 :B4 :G4 :B4 :G4 0 0 0 0
                      :Bb4 :G5 :G5 :B5 :A5 :G5 :E5 :G5 :F#5 :F5 0 0 0
                      :E5 :E5 :F5])
(def part-thirtyfive-time [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16
                           1/8 1/4 1/4 1/4 1/4 3/4 1/8 1/8 1/8 1/8 3/8 1/8 3/4
                           1/8 1/8 1/2 1/4 1/4 1/8 1/8 1/2 3/2])

(def part-thirtysix [:F4 :G4 :B4 :G4 :B4 :G4])
(def part-thirtysix-time [1/16 1/16 1/16 1/16 1/16 1/16])

(def part-thirtyseven [:F4 :G4])
(def part-thirtyseven-time [1/16 1/16])

(def part-thirtyeight [:F4 :G4 :B4])
(def part-thirtyeight-time [1/16 1/16 1/16])

(def part-thirtynine [:B4 :G4 :F4 :G4 :B4 :C5])
(def part-thirtynine-time [1/16 1/16 1/16 1/16 1/16 1/16])

(def part-forty [:B4 :F4])
(def part-forty-time [1/16 1/16])

(def part-fortyone [:B4 :G4])
(def part-fortyone-time [1/16 1/16])

(def part-fortytwo [:C5 :B4 :A4 :C5])
(def part-fortytwo-time [1 1 1 1])

(def part-fortythree [:F5 :E5 :F5 :E5 :E5 :E5 :E5 :F5 :E5])
(def part-fortythree-time [1/16 1/16 1/16 1/16 1/8 1/8 1/8 1/16 1/16])

(def part-fortyfour [:F5 :E5 :E5 :E5 :E5 :C5])
(def part-fortyfour-time [1/8 1/8 1/8 1/8 1/4])

(def part-fortyfive [:D5 :D5 :G4])
(def part-fortyfive-time [1/4 1/4 1/4])

(def part-fortysix [:G4 :D5 :E5 :D5 0 :G4 0 :G4 0 :G4 :G4 :D5 :E5 :D5])
(def part-fortysix-time [1/16 1/16 1/16 1/16 1/8 1/8 1/8 1/8 1/8 1/8 1/16
                         1/16 1/16 1/16])

(def part-fortyseven [:D5 :E5 :D5])
(def part-fortyseven-time [1/16 1/16 1/8])

(def part-fortyeight [:G4 :G4 :F4 :F4])
(def part-fortyeight-time [3/2 1 1 1/4])

(def part-fortynine [:F4 :G4 :Bb4 :G4 :B4 :G4])
(def part-fortynine-time [1/16 1/16 1/16 1/16 1/16 1/16])

(def part-fifty [:F4 :G4])
(def part-fifty-time [1/16 1/16])

(def part-fiftyone [:F4 :G4 :Bb4])
(def part-fiftyone-time [1/16 1/16 1/16])

(def part-fiftytwo [:G4 :Bb4])
(def part-fiftytwo-time [1/16 1/16])

(def part-fiftythree [:Bb4 :G4])
(def part-fiftythree-time [1/16 1/16])

(def parts [part-one part-two part-three part-four part-five
               part-six part-seven part-eight part-nine part-ten
               part-eleven part-twelve part-thirteen part-fourteen
               part-fifteen part-sixteen part-seventeen part-eighteen
               part-nineteen part-twenty part-twentyone part-twentytwo
               part-twentythree part-twentyfour part-twentyfive
               part-twentysix part-twentyseven part-twentyeight
               part-twentynine part-thirty part-thirtyone
               part-thirtytwo part-thirtythree part-thirtyfour
               part-thirtyfive part-thirtysix part-thirtyseven
               part-thirtyeight part-thirtynine part-forty
               part-fortyone part-fortytwo part-fortythree
               part-fortyfour part-fortyfive part-fortysix
               part-fortyseven part-fortyeight part-fortynine
               part-fifty part-fiftyone part-fiftytwo part-fiftythree])

(def times [part-one-time part-two-time part-three-time part-four-time
            part-five-time part-six-time part-seven-time part-eight-time
            part-nine-time part-ten-time part-eleven-time part-twelve-time
            part-thirteen-time part-fourteen-time part-fifteen-time
            part-sixteen-time part-seventeen-time part-eighteen-time
            part-nineteen-time part-twenty-time part-twentyone-time
            part-twentytwo-time part-twentythree-time part-twentyfour-time
            part-twentyfive-time part-twentysix-time part-twentyseven-time
            part-twentyeight-time part-twentynine-time part-thirty-time
            part-thirtyone-time part-thirtytwo-time part-thirtythree-time
            part-thirtyfour-time part-thirtyfive-time part-thirtysix-time
            part-thirtyseven-time part-thirtyeight-time part-thirtynine-time
            part-forty-time part-fortyone-time part-fortytwo-time
            part-fortythree-time part-fortyfour-time part-fortyfive-time
            part-fortysix-time part-fortyseven-time part-fortyeight-time
            part-fortynine-time part-fifty-time part-fiftyone-time
            part-fiftytwo-time part-fiftythree-time])

(defn build-piece [max-reps xs]
  (flatten (map #(take (* (count %1) (rand-int max-reps)) (cycle %1)) xs)))

(defn player
  [t speeds notes]
  (let [n (first notes)
        notes (next notes)
        t-next (+ t (first speeds))]
    (when n
      (at t
          (sampled-piano (note n)))
      (apply-at t-next #'player [t-next  (next speeds) notes]))))

(def metro (metronome 32))

(defn metro-player
  [metro beat notes offsets]
  (let [n (first notes)
        notes (next notes)
        offset (first offsets)
        offsets (next offsets)
        next-offset (first (next offsets))]

    (at (metro beat) (sampled-piano (note n) 0.6))
    (apply-at
     (metro (+ beat offset)) #'metro-player [metro (+ beat offset) notes offsets])))

(defn play-measure
  [metro notes offsets times]
  (metro-player metro (metro)
                (take (* times (count notes)) (cycle notes))
                (take (* times (count offsets)) (cycle offsets))))

(stop)

(play-measure metro rhythm rhythm-time 1000)

(do
  (. Thread (sleep 10000))
  (play-measure metro (build-piece 10 parts) (build-piece 10 times) 1)
  (. Thread (sleep 1000))
  (play-measure metro (build-piece 10 parts) (build-piece 10 times) 1)
  (. Thread (sleep 1000))
  (play-measure metro (build-piece 10 parts) (build-piece 10 times) 1)
  (. Thread (sleep 1000))
  (play-measure metro (build-piece 10 parts) (build-piece 10 times) 1)
  (. Thread (sleep 1000))
  (play-measure metro (build-piece 10 parts) (build-piece 10 times) 1)
  (. Thread (sleep 1000))
  (play-measure metro (build-piece 10 parts) (build-piece 10 times) 1))
