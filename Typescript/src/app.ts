// https://jsonplaceholder.typicode.com/users/2

type User = {
   id: number;
   name: string;
   username: string;
   email: string;
   address: {
      street: string;
      suite: string;
      city: string;
      zipcode: string;
      geo: {
         lat: string;
         lng: string;
      };
   };
   phone: string;
   website: string;
   company: {
      name: string;
      catchPhrase: string;
      bs: string;
   };
}

const getUserById = async (id : number) : Promise<User> => {
   try {
      const fetchApi = await fetch(`https://jsonplaceholder.typicode.com/users/${id}`);
      const resApi = await fetchApi.json();

      console.log(resApi);
      
      return resApi;
      
   } catch (err) {
      console.log(err);
      throw new Error('Failed to fetch user');
   }
}
getUserById(5);


const getUsers = async () : Promise<User> => {
   try {
      const fetchApi = await fetch(`https://jsonplaceholder.typicode.com/users`);
      const resApi = await fetchApi.json();

      console.log(resApi);
      
      return resApi;
      
   } catch (err) {
      console.log(err);
      throw new Error('Failed to fetch users');
   }
}

getUsers();