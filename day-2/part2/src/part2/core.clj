(ns part2.core
  (:gen-class)
  (:require [clojure.math.combinatorics :as combo]))

(defn read-input [file]
  (for [line (clojure.string/split-lines (slurp file))]
    (->> (clojure.string/split line #"\t")
         (map #(Integer/parseInt %))
         (conj))))

(defn divide-pair [pair]
  (let [division-result (/ (apply max pair) (apply min pair))]
    (if (integer? division-result)
      division-result
      nil)))

(defn find-divisible [row]
  (first
    (remove nil?
            (map divide-pair (combo/combinations row 2)))))

(defn -main
  "I don't do a whole lot ... yet."
  [file]
  (apply + (map find-divisible (read-input file))))
