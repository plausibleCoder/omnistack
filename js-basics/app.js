// Import the 'fs' (File System) module
const fs = require('fs');

console.log("1. Starting to read file asynchronously...");

// Asynchronously read 'test.txt'
// Node.js hands this task off to libuv, and your JavaScript continues immediately.
fs.readFile('test.txt', 'utf8', (err, data) => {
    if (err) {
        console.error("Error reading file:", err);
        return;
    }
    console.log("3. File read complete! Content:\n", data);
});

console.log("2. This message appears BEFORE the file content, because fs.readFile is non-blocking!");

// Let's also try a synchronous read for comparison
console.log("\n--- Synchronous Read Example ---");

console.log("4. Starting to read file synchronously...");
try {
    // This will block the entire JavaScript execution until the file is read.
    const syncData = fs.readFileSync('test.txt', 'utf8');
    console.log("5. Synchronous file read complete! Content:\n", syncData);
} catch (err) {
    console.error("Error reading file synchronously:", err);
}
console.log("6. This message appears AFTER the synchronous file content.");
