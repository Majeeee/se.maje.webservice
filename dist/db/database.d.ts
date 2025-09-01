import { Db } from "mongodb";
/** Attempts to connect to database.
* Returns a promise.
* Throws error at failed attempt. */
export declare function runDB(): Promise<void>;
export declare function getDB(): Db;
export declare function closeDB(): Promise<void>;
//# sourceMappingURL=database.d.ts.map