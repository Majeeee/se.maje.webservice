
import express from "express"
import type { Request, Response } from "express";
import "dotenv/config"
import { closeDB, runDB, getDB } from "./db/database.js"
import { ObjectId } from "mongodb";
import type { User } from "./models/Usermodel.ts"

const app = express()
app.use(express.json()); //läsa JSON från req.body
const port: number = Number(process.env.PORT) || 3000 // Could crash






// Root endpoint
app.get("/", (req, res) => {
  res.status(200).send("Hello world!")
})

app.post("/users", async (req: Request, res: Response) => {
  try {
    const newUser: User = {
      name: req.body.name,
      email: req.body.email,
      age: req.body.age,
    };

// Här kan du spara i DB om du vill:
    // const db = getDB();
    // await db.collection("users").insertOne(newUser);
    res.status(201).send(newUser);
  } catch (err) {
    res.status(500).json({ error: "Kunde inte skapa användare", details: err });
  }
});





// GET /users/:id – hämta användare via ObjectId
app.get("/users/:id", async (req: Request, res: Response) => {
  try {
    const db = getDB();
    const userId = req.params.id;

    // Kontrollera att id finns
    if (!userId) {
      return res.status(400).json({ error: "ID saknas i URL" });
    }

    // Kontrollera att id är ett giltigt ObjectId
    if (!ObjectId.isValid(userId)) {
      return res.status(400).json({ error: "Ogiltigt ID" });
    }

    const user = await db
      .collection("users")
      .findOne({ _id: new ObjectId(userId) });

    if (!user) {
      return res.status(404).json({ error: "Användare hittades inte" });
    }

    res.json(user);
  } catch (err) {
    res.status(500).json({ error: "DB-fel", details: err });
  }
});



// Start Server on Port Variable
/*app.listen(port, () => {
  console.log(`Listening on port ${port}`)
})*/

// Server startup async function - goes here


async function startServer() {
try {
await runDB()
app.listen(port, () => {
console.log(`Listening to port ${port}`)
console.log(`Start the app: http://localhost:${port}`)
})
process.on("SIGINT", async () => {
console.log("Cleaning up...")
await closeDB()
process.exit(0)
})
} catch (error) {
console.log(error)
}
}
startServer()