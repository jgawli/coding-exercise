(ns clojure-coding-exercise.core)

(defn median [x]
  (let [sorted (sort x)
        cnt (count x)
        halfway (quot cnt 2)]
    (if (odd? cnt)
      (nth sorted halfway)
      (let [first-val (last (take halfway x))
            second-val (first (nthnext x halfway))]
        (int (/ (+ first-val second-val) 2))))))

(defn median-stream [x]
  (for [xs x
        :let [result []]]
      (cons (median (take (+ 1 (.indexOf x xs)) x)) result)))
