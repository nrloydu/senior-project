export class Poll {
    pollTitle: string;
    deadline: number;
    option: string[] = [];
    users: string;
    visLimit: number;
}

export class Option {
    index: number;
    text: string;
    votes: number;
}