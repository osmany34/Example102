--film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?
select count(*)
from films
where length > (select avg(length) from films);

--film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?
select count(*)
from films
where rental_rate = (select max(rental_rate) from films);

--film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.
select *
from films
where rental_rate = (select mın(rental_rate) from films)
and replacement_cost = (select mın(replacement_cost) from films);

--payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.
SELECT customer_id, COUNT(*) AS alisveris_sayisi
FROM payment
GROUP BY customer_id
ORDER BY alisveris_sayisi DESC;
