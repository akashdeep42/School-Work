(define (inc_n x)
  (lambda (y) (+ x y)))

((inc_n 3) 2)

((inc_n -2) 3)

(define (len lst)
  (let loop ((lst lst) (count 0))
    (cond ((null? lst) count)
          (else (loop (cdr lst) (+ count 1))))))

(len'(2 1))

(define (maxmin lst)
  (if (null? lst)
      #f 
      (let loop ((lst lst) (min (car lst)) (max (car lst)))
        (if (null? lst)
            (list max min)
            (loop (cdr lst)
                  (if (< (car lst) min) (car lst) min)
                  (if (> (car lst) max) (car lst) max))))))


(maxmin '(4 2 -1 10))


(define (mem x lst)
  (cond ((null? lst) #f)
        ((eq? x (car lst)) #t) 
        (else (mem x (cdr lst))))) 

(mem '(1)'(1 4 -2))


(define (ins x lst)
  (cond ((mem x lst) lst) 
        (else (cons x lst))))
(ins 5' (2 10 -3))

(define (numT f lst)
  (cond ((null? lst) 0) 
        ((f (car lst)) (+ 1 (numT f (cdr lst)))) 
        (else (numT f (cdr lst)))))
(numT number? '(1 -5 -4 (2 1) 7))

(define (moreT f lst1 lst2)
  (let ((count1 (numT f lst1))
        (count2 (numT f lst2)))
    (cond ((> count1 count2) 1)
          ((> count2 count1) 2)
          (else 0))))
(moreT negative? '(8 -4 3 8) '(7 -3 -2 1 -5))
(moreT even? '(8 -4 3 8) '(6 3 2 1 -4))