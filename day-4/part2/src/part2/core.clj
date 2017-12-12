(ns part2.core
  (:gen-class))

(defn sort-string [word]
  (apply str (sort word)))

(defn read-input [file]
  (for [line (clojure.string/split-lines (slurp "resources/input"))]
    (->> (clojure.string/split line #" ")
         (map sort-string)
         (conj))))

(defn check-valid [row]
  (if (= (count row) (count (distinct row)))
    row
    nil))

(defn -main
  "I don't do a whole lot ... yet."
  [file]
  (count
    (remove nil?
            (map check-valid (read-input file)))))
