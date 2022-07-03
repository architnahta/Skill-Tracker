import { Skills } from "./skills";

export class Associate {
    associateId: string;
    name: string;
    email: string;
    mobile:string;
    skills:Skills[] | undefined;
}
