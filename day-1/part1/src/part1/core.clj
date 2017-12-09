(ns part1.core
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
      (for [[a b] (partition 2 1 digits)]
           (is-match a b)))

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
