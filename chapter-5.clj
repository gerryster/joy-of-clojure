(defn neighbors
  ; this is a varity funciton which calls itself recursivly if the deltas are
  ; not passed in
  ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]]
              size
              yx))
  ([deltas size yx]
     (filter (fn [new-yx]
               (every? #(< -1 % size) new-yx))
             (map #(vec (map + yx %))
               deltas))))

(println (neighbors 3 [0 0]))

(println (neighbors 3 [1 1]))

(println "three argument form: " (neighbors [[-2 0] [2 0] [0 -2] [0 2]] 4 [1 1]))