;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(defn xors [max-x max-y]
  (for [x (range max-x) y (range max-y)]
       [x y (bit-xor x y)]))

(xors 2 2)

;(for [meth (.getMethods java.awt.Frame)
;:let [name (.getName meth)]
;:when (re-find #"Vis" name)]
;name)

(def frame (java.awt.Frame.))

(.setVisible frame true)

(.setSize frame (java.awt.Dimension. 255 255))

(def gfx (.getGraphics frame))

(defn xors [max-x max-y]
  (for [x (range max-x) y (range max-y)]
       [x y (rem (bit-xor x y) 256)]))

(defn set-of-three [max-x max-y max-z]
  (for [x (range max-x) y (range max-y) z (range max-z)]
       [x y z]))

(defn dxors [list]
  (doseq [[x y z] list]
  (.setColor gfx (java.awt.Color. x y z))
  (.fillRect gfx x y 1 1)
))

(defn clear [g] (.clearRect g 0 0 200 200))

(defn f-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn draw-values [f xs ys]
  (clear gfx)
  (.setSize frame (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1)))

;(dxors (xors 2 2))

;(set-of-three 2 2 2)

