export type IItemObject = {
   id: number;
   name: string;
}

export const enum TaskStatus {
  TODO = "TODO",
  ONGOING = "ONGOING",
  DONE = "DONE"
}

// export type TaskStatus = "TODO" | "ONGOING" | "DONE";

export type Project = {
   id: number;
   name: string;
   userId: number;
   tasks: Task[];
}

export type User = {
   id: number;
   name: string;
   password: string;
   email: string;
   projects: Project[]
}

export type Task = {
   id: number;
   title: string;
   description: string;
   status: TaskStatus;
   estimationHours: number;
   projectId: number;
}