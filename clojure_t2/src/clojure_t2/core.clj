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

; Permutacion con repeticion: P = n!/(a! b! c!)
; se usara la funcion factorial desarrollada previamente
(defn perm_con_rep [n a b c]
  ; Se validara que a + b + c <= n
  (if (> (+ a b c) n)
    nil
    (/ (factorial n) 
       (* (factorial a) (factorial b) (factorial c)))
  )
)

; Combinacion sin repeticion C = n!/((n-p)!p!) 
(defn comb_sin_rep [n p]
  (/ (factorial n)
     (* ((comp factorial -) n p) ; usando composicion de funciones
        (factorial p))
  )
)

(defn -main
  [& args]
  (print (factorial 20) "\n")
  (print (perm_con_rep 10 2 3 5) "\n")
  (print (comb_sin_rep 5 5) "\n")
)
