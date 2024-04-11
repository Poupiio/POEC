Information Générales :

Installer les Packets Node
```
npm install
```

Lancer le serveur
```
ng serve
```

Lancer le serveur avec un port spécifique
```
ng serve --port 5555
```


## IL FAUT IMPÉRATIVEMENT ETRE DANS LE DOSSIER DU PROJECT


Project Backend de MAMAZON

Afin de faire fonctionner le projet il vvous faut coder le back de MAMAZON.

Pour cela vous devez faire un project Java Rest API avec Spring Boot.

Vous devez créer une base de donnée avec les tables suivantes :
- User
````
{
	id: number;
	name: string;
	email: string
	password: string;
	age: number;
	panier : Panier;
}
````

- Item
````
{
	id: number;
	name: string;
	photo : string;
	price: number;
	quantity: number;
	Category : string;
}
````


- Panier
````
{
	id: number;
	items: Item[];
}
````


Afin de faire fonctionner le projet vous devez coder les routes suivantes :
- Get http://localhost:3050/items
- Get http://localhost:3050/items/:id
- Post http://localhost:3050/items
- Put http://localhost:3050/items/:id
- Delete http://localhost:3050/items/:id

- Get http://localhost:3050/users
- Get http://localhost:3050/users/:id
- Post http://localhost:3050/users
- Put http://localhost:3050/users/:id
- Delete http://localhost:3050/users/:id
- Post http://localhost:3050/users/login
- Post http://localhost:3050/users/register

- Get http://localhost:3050/paniers
- Get http://localhost:3050/paniers/:id
- Post http://localhost:3050/paniers
- Put http://localhost:3050/paniers/:id
- Delete http://localhost:3050/paniers/:id


