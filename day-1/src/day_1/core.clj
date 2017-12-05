(ns day-1.core
  (:gen-class))

(def test-match '((1 2 3) (2 3 3) (3 3 4) (3 4 1)))

(defn read-input [file]
  (map #(Integer/parseInt %)
        (butlast (clojure.string/split
                   (slurp file) #""))))

(defn is-match [pair]
  (if (== (first pair) (second pair))
     (first pair)
     0))

(defn find-consecutive-matches [digits]
  (into (map is-match (partition 2 1 digits))
        (map is-match (partition 2 2 digits))))

(defn check-first-last [digits]
  (if (= (first digits) (last digits))
    (first digits)
    0))

(defn -main
  "I don't do a whole lot ... yet."
  [file]
  (let [input (read-input file)]
    (+ (check-first-last input)
       (apply + (find-consecutive-matches input)))))

