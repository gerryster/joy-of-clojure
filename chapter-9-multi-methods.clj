; repl usage: (load-file "chapter-9-multi-methods.clj")
; (ns joy.udp)

(ns joy.udp
  "The Universal Design Pattern (UDP) example from section 9.2."
  (:refer-clojure :exclude [get]))

(defn beget [o p] (assoc o ::prototype p))

(def put assoc)

(defn get [m k]
  (when m
    (if-let [[_ v] (find m k)]
      v
      (recur (::prototype m) k))))

(def clone (partial beget {}))

(defmulti compiler :os)
(defmethod compiler ::unix [m] (get m :c-compiler))
(defmethod compiler ::osx  [m] (get m :llvm-compiler))

(def clone (partial beget {}))
(def unix   {:os ::unix, :c-compiler "cc", :home "/home", :dev "/dev"})
(def osx  (-> (clone unix)
              (put :os ::osx)
              (put :llvm-compiler "clang")
              (put :home "/Users")))
