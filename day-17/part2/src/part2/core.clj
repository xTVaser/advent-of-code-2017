(ns part2.core
  (:gen-class))

(defn spinlock [insertions steps]
  (loop [index 0
         fakeSize 1
         val 1]
    (when (<= val insertions)
      (let [at (inc (mod (+ index steps) fakeSize))]
        (when (= at 1) ; only care when updating the value next to 0
          (println val))
        (recur at (inc fakeSize) (inc val))))))

(defn -main
  "I don't do a whole lot ... yet."
  [steps]
  (spinlock 50000000 steps))