const sayHello = (name: string) => {
   return `Hello ${name}!`;
}

// console.log(sayHello("World"));

const chaine : string = "Coucou je suis une chaîne de caractères";
// console.log(chaine);

const msg = sayHello(chaine);
// console.log(msg);



/* ------------------------------------------------
                     EXERCICE
   ------------------------------------------------
Le but va être de réaliser un CRM (en nodejs).
- Client
  - name
  - birthday (le client peux choisir de ne pas la donner)
  - assignee (utilisateur "contact privilégié")
  - Projects
    - Tasks
      - deadline (optionnel)
      - name
- User
  - name
  - password
*/

// Fonction pour formater la date au format JJ-MM-AAAA
// function formatDate(date: Date): string {
   //    const day = ("0" + date.getDate()).slice(-2);
   //    const month = ("0" + (date.getMonth() + 1)).slice(-2);
   //    const year = date.getFullYear();
   //    return `${day}/${month}/${year}`;
   // }


enum Status {
   To_Do,
   Ongoing,
   Done
}

type Task = {
   deadline?: Date;
   name: string;
   status: Status;
}

type Project = {
   name: string;
   tasks: Task[];
}

type User = {
   name: string;
   password: string;
}

type Client = {
   name: string;
   birthday: Date | undefined;
   assignee: User;
   projects: Project[];
}


// const user1 : User = {
//    name: "Fleur",
//    password: "123"
// }

// const user2 : User = {
//    name: "Moi",
//    password: "secret"
// }
// const user3 : User = {
//    name: "Coucou",
//    password: "surprise"
// }

// const task1 : Task = {
//    deadline: new Date(),
//    name: "Tâche n°1"
// }
// const task2 : Task = {
//    deadline: new Date(),
//    name: "Tâche n°2"
// }
// console.log(task1, task2); 

// const proj1 : Project = {
//    tasks: [task2]
// }

// console.log(proj1);

// const client1 : Client = {
//    name: "Client 1",
//    birthday: new Date("1993/09/13"),
//    assignee: user2,
//    projects: [proj1]
// }
// console.log(client1);


/* ------------------------------------------------
                     CORRECTION
   --------------------------------------------- */

function randomDate(start : Date, end : Date) {
   return new Date(start.getTime() + Math.random() * (end.getTime() - start.getTime()));
}
// Générer un nom aléatoire
function randomName() {
   const names = ['Alice', 'Bob', 'Charlie', 'David', 'Eve', 'Frank', 'Grace', 'Henry', 'Ivy', 'Jack'];
   return names[Math.floor(Math.random() * names.length)];
}
// Générer une tâche
function generateTask() {
   let status: Status;
   const random = Math.random();
   if (random < 0.33) {
     status = Status.To_Do;
   } else if (random < 0.67) {
     status = Status.Ongoing;
   } else {
     status = Status.Done;
   }
   return {
     name: `Task ${Math.floor(Math.random() * 100) + 1}`,
     deadline: Math.random() > 0.5 ? randomDate(new Date(), new Date(Date.now() + 7 * 24 * 60 * 60 * 1000)) : undefined,
     status: status
   };
}
// Générer un projet
function generateProject() {
   const numTasks = Math.floor(Math.random() * 5) + 1;
   const tasks = [];
   for (let i = 0; i < numTasks; i++) {
     tasks.push(generateTask());
   }
   return {
     name: `Project ${Math.floor(Math.random() * 100) + 1}`,
     tasks: tasks
   };
}
// Générer un utilisateur
function generateUser() {
   return {
     name: randomName(),
     password: `password${Math.floor(Math.random() * 100) + 1}`
   };
}
// Générer un client
function generateClient() {
   const numProjects = Math.floor(Math.random() * 3) + 1;
   const projects = [];
   for (let i = 0; i < numProjects; i++) {
     projects.push(generateProject());
   }
   return {
     name: randomName(),
     birthday: Math.random() > 0.5 ? randomDate(new Date(1970, 0, 1), new Date()) : undefined,
     assignee: generateUser(),
     projects: projects
   };
}

// -------------------------------------------- //
const getNumSpace = (numspace: number) => (new Array(numspace)).fill(" ").join("");

const display_user = (user: User, indent: number = 0) => {
   console.log(`${getNumSpace(indent)}- User: ${user.name}`);
}

const display_status = (status: Status, indent: number = 0) => {
   console.log(`${getNumSpace(indent)}- Status: ${status}`);
}

const display_task = (task: Task, indent: number = 0) => {
   console.log(`${getNumSpace(indent)}- Task: ${task.name}`);
   if (task.deadline)
      console.log(`${getNumSpace(indent + 2)}- Deadline: ${task.deadline.toLocaleDateString()}`)
   
   let status: string;
   switch(task.status) {
      case Status.To_Do:
         status = "To Do";
         break;
      case Status.Ongoing:
         status = "Ongoing";
         break;
      case Status.Done:
         status = "Done";
         break;
      default:
         status = "Unknown";
         break;
   }
   console.log(`${getNumSpace(indent + 2)}- Status: ${status}`);
}

const display_project = (project: Project, indent: number = 0) => {
   console.log(`${getNumSpace(indent)}- Project: ${project.name}`);
   project.tasks.forEach(i => display_task(i, indent + 2));
}

const display_client = (client: Client) : void => {
   console.log(`Client: ${client.name}`);
   if (client.birthday)
      console.log("  - birthday:", client.birthday.toLocaleDateString());
   display_user(client.assignee, 2);
   client.projects.forEach(i => display_project(i, 2));
}


const clientData = generateClient();
display_client(clientData);