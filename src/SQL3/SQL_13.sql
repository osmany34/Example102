--film tablosundan 'K' karakteri ile başlayan en uzun ve replacenet_cost u en düşük 4 filmi sıralayınız.
select *
from film
where title lıke 'K%'
order by length desc, replacement_cost
LIMIT 4;

--film tablosunda içerisinden en fazla sayıda film bulunduran rating kategorisi hangisidir?
select rating, count(*) as film_sayisi
from film
group by rating
order by film_sayisi desc
LIMIT 1;

--customer tablosunda en çok alışveriş yapan müşterinin adı nedir?
select first_name, last_name
from customer
where customer_id = (
    select customer_id
    from payment
    group by customer_id
    order by count(*) desc
    LIMIT 1
);

--category tablosundan kategori isimlerini ve kategori başına düşen film sayılarını sıralayınız.
select count(*) category.name
FROM category
JOIN film_category ON category.category_id = film_category.category_id
JOIN film ON film.film_id = film_category.film_id
group by    category.name;

--film tablosunda isminde en az 4 adet 'e' veya 'E' karakteri bulunan kç tane film vardır?
SELECT title
FROM film
WHERE title ILIKE '%e%e%e%e%';