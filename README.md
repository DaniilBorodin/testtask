Тестовые задания
============================


* Первое задание.

Основной класс JavaTasks. В методе main вызов restapi.getRequests(10) выполняет данное задание.
Основная реализация в классе RestApi и несколько вспомогательных классов. В результате в корне проекта
появляются два файла:

sortedByName.json - отсортированные по Name.
sortedByDane.json - отсортированные по Date.

* Второе задание

Основной класс JavaTasks. В методе main вызов cs.countAndSortElements(list) выполняет данное задание.
Основная реализация в классе CountAndSort. Результат выводится в консоль.

* Третье задание

Необходимые sql запросы:

1. Найти клиентов, у которых нет почты. Вывести его ФИО.
```sql
SELECT fio, email FROM client WHERE email IS NULL OR email ='';
```

2. Найти самый дорогой продукт. Вывести его название и цену.
```sql
SELECT name, max(price) FROM product GROUP BY name LIMIT 1;
```

3. Найти продукт, который еще не куплен клиентами. Вывести его название.
```sql
SELECT name FROM product LEFT JOIN client_and_product ON client_and_product.product_id = product.id WHERE client_id IS NULL;
```


