--city tablosu ile country tablosunda bulunan şehir (city) ve ülke (country) isimlerini birlikte görebileceğimiz LEFT JOIN sorgusunu yazınız.
select city.city_name,  country.country_name
from city
left joın country
on city.country_id = country.country_id;

--customer tablosu ile payment tablosunda bulunan payment_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz RIGHT JOIN sorgusunu yazınız.
select
    payment.payment_id,
    customer.first_name,
    customer.last_name
from
    payment
rıght joın
    customer on payment.customer_id = customer.customer_id;

--customer tablosu ile rental tablosunda bulunan rental_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz FULL JOIN sorgusunu yazınız.
SELECT
    rental.rental_id,
    customer.first_name,
    customer.last_name
FROM
    rental
FULL JOIN
    customer ON rental.customer_id = customer.customer_id;

