import express from "express"
import "dotenv/config"
import { closeDB, runDB } from "./db/database.js"

const app = express()
const port: number = Number(process.env.PORT) || 3000 // Could crash

app.get("/", (req, res) => {
  res.status(200).send("Hello world!")
})

// Start Server on Port Variable
app.listen(port, () => {
  console.log(`Listening on port ${port}`)
})

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