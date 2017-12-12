(ns part1.core
  (:gen-class))

(defn read-input [file]
  (for [line (clojure.string/split-lines (slurp file))]
    (->> (clojure.string/split line #" ")
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
