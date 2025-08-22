import express from "express"
import "dotenv/config"

const app = express()
const port: number = Number(process.env.PORT) || 3000 // Could cras
const secret = process.env.MY_GLOBAL_TEST_SECRET // Check later as intellisense doesn't work

app.get("/", (req, res) => {
  res.status(200).send("Hello world!")
})

// Start Server on Port Variable
app.listen(port, () => {
  console.log(`Listening on port ${port}`)
  console.log(secret)
})