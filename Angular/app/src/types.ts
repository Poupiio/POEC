export type IItemObject = {
   id: number;
   name: string;
}

export const enum TaskStatus {
  TODO = "TODO",
  ONGOING = "ONGOING",
  DONE = "DONE"
}

export type Project = {
   id: number;
   name: string;
   userId: number;
   tasks: Task[];
}

export type User = {
   name: string;
   password: string;
   email: string;
   projects: Project[];
   sub: string;   // correspond à l'id du User
   exp: string;   // expiration date
   iat: number;   // issued at (date)
}

export type TaskForm = {
   title: string;
   description?: string;
   status: TaskStatus;
   estimationHours: number;
   projectId: number;
}

export type TaskToDisplay = {
   title: string;
}

export type TaskWithDatabaseId = {
   id: number; // ID local de la liste
   title: string;
   databaseId: number; // ID de la base de données
}

export type Task = {
   id: number;
   title: string;
   description?: string;
   status: TaskStatus;
   estimationHours: number;
   projectId: number;
}
