(ns part2.core
  (:gen-class))

(defn read-input [file]
  (map #(Integer/parseInt %)
       (butlast (clojure.string/split
                  (slurp file) #""))))

(defn is-match [a b]
  (if (== a b)
    a
    0))

(defn find-consecutive-matches [digits]
  (let [step (/ (count digits) 2)
        digit-indexes (map vector digits (range))]
    (for [[curr index] digit-indexes]
      (let [step-elem (nth digits (+ step index) 0)]
        (is-match curr step-elem)))))

(defn split-and-reverse [digits]
  (->> (split-at (/ (count digits) 2) digits)
       (reverse)
       (flatten)
       (into [])))

(defn -main
  "I don't do a whole lot ... yet."
  [file]
  (let [input (read-input file)]
    (+ (apply + (find-consecutive-matches input))
       (apply + (find-consecutive-matches (split-and-reverse input))))))
