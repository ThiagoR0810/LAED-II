-- Aluno: Thiago Ribeiro Correa
-- Implemente o quicksort em uma função para ordernar uma lista de números recebida como parâmetro. Após a ordenação, a função deve retornar a lista ordenada. 

qsort :: [Int] -> [Int]
qsort [] = []
qsort (a:x) = qsort [ b | b <- x, b <= a ] ++ [a] ++ qsort [ b | b <- x, b > a ]

