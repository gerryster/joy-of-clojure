(println "\ndefine very-lazy")
(def very-lazy (-> (iterate #(do (print \.) (inc %)) 1)
                    rest rest rest))

(println "\ndefine less-lazy")
(def less-lazy (-> (iterate #(do (print \.) (inc %)) 1)
                    next next next))

(println "\nevaluate very-lazy")
(println (first very-lazy))

(println "\nevaluate less-lazy")
(println (first less-lazy))

(def very-lazy-no-thread (rest(rest(rest(iterate #(do (print \.) (inc %)) 1)))))

(println "\nevaluate very-lazy-no-thread")
(println (first very-lazy-no-thread))