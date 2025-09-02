export interface User {
  _id?: string;   // MongoDB ObjectId blir en sträng i response
  name: string;
  email: string;
  age: number;
}
