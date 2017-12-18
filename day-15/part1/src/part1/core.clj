(ns part1.core
  (:gen-class))

(defn compute-val [mul n]
  (mod (* mul n) 2147483647))

(defn gen-16bit [n]
  (subs (clojure.string/replace
          (format "%32s" (Integer/toBinaryString n))
          #" " "0")
        16))

(defn process [initA initB iterations]
  (let [counter (atom 0)]
    (loop [initA initA
           initB initB
           iter 0]
      (when (< iter iterations)
        (let [valA (compute-val 16807 initA)
              valB (compute-val 48271 initB)]
          (when (= (gen-16bit valA) (gen-16bit valB))
            (println (deref counter) " / " iter)
            (swap! counter inc))
          (recur valA valB (inc iter)))))
    (deref counter)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (process 277 349 40000000))
