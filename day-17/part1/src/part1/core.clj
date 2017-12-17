(ns part1.core
  (:gen-class))

(defn circ-index [coll i]
  (mod i (count coll)))

(defn insert-at [coll at n]
  (let [split (split-at at coll)]
    (concat (first split) [n] (second split))))

(defn spinlock [insertions steps]
  (let [state (atom [0])]
    (loop [index 0
           val 1]
      (when (<= val insertions)
        (let [s (deref state)
              at (inc (circ-index s (+ index steps)))]
          (reset! state (insert-at s at val))
          ; debug (println (deref state))
          (recur at (inc val)))))
    (deref state)))

(defn -main
  "I don't do a whole lot ... yet."
  [steps]
  (let [result (spinlock 2017 steps)]
    (nth result (inc (.indexOf result 2017)))))