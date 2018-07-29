(ns clojure-t2.core
  (:gen-class))

; Factorial
(defn factorial [x]  ; declaro funcion factorial con 1 argumento
  ((fn [n acum]  ; Hago uso de una funcion anonima con 2 parametros
                ; n -> valor inicial | acum -> 'acumulador' del resultado
    (if (<= n 1)  ; Caso base: n <= 1
      acum  ; Si se cumple el caso base retorna acum
      (recur (dec n) (* acum n)))) x 1
    )   
)

(defn -main
  [& args]
  (print (factorial 20) "\n")
)
