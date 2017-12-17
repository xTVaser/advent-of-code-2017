(ns part1.core
  (:gen-class))

(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(defn read-input [file]
  (let [line (slurp file)]
    (clojure.string/split line #",")))

(defn spin [s n]
  (let [vec (into [] s)
        n (* -1 n)
        cv (count vec), n (mod n cv)]
    (concat (subvec vec n cv) (subvec vec 0 n))))

(defn swap [s i1 i2]
  (let [vec (into [] s)]
    (assoc vec i2 (vec i1) i1 (vec i2))))

(defn dance [steps]
  (let [programs (atom (char-range \a \p))]
    (for [step steps]
      (let [vals (clojure.string/split (apply str (rest step)) #"/")]
        (cond
          (= (first step) \s) (reset! programs
                                      (spin (deref programs)
                                            (Integer/parseInt (apply str (rest step)))))
          (= (first step) \x) (reset! programs
                                      (swap (deref programs)
                                            (Integer/parseInt (nth vals 0))
                                            (Integer/parseInt (nth vals 1))))
          (= (first step) \p) (reset! programs
                                      (swap (deref programs)
                                            (.indexOf (deref programs) (first (nth vals 0)))
                                            (.indexOf (deref programs) (first (nth vals 1)))))
          :else nil)))))

(defn -main
  "I don't do a whole lot ... yet."
  [file]
  (apply str (last
               (dance (read-input file)))))
