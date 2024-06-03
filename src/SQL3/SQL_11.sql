--actor ve customer tablolarında bulunan first_name sütunları için tüm verileri sıralayalım.
select first_name from actor
unıon
select first_name from customer
order by first_name;

--actor ve customer tablolarında bulunan first_name sütunları için kesişen verileri sıralayalım.
select first_name from actor
ıntersect
select first_name from customer
order by first_name;

--actor ve customer tablolarında bulunan first_name sütunları için ilk tabloda bulunan ancak ikinci tabloda bulunmayan verileri sıralayalım.
SELECT first_name FROM actor
EXCEPT
SELECT first_name FROM customer
ORDER BY first_name;

--İlk 3 sorguyu tekrar eden veriler için de yapalım.
select first_name from actor
unıon all
select first_name from customer
order by first_name;

select first_name from actor
ıntersect all
select first_name from customer
order by first_name;

SELECT first_name FROM actor
EXCEPT ALL
SELECT first_name FROM customer
ORDER BY first_name;