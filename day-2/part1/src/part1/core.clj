(ns part1.core
  (:gen-class))

(defn read-input [file]
  (for [line (clojure.string/split-lines (slurp file))]
    (->> (clojure.string/split line #"\t")
         (map #(Integer/parseInt %))
         (conj))))

(defn checksum-row [row]
  (- (apply max row) (apply min row)))

(defn -main
  "I don't do a whole lot ... yet."
  [file]
  (apply + (map checksum-row (read-input file))))
