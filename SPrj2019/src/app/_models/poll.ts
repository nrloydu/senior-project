export class Poll {
    id: number;
    ownerId: number;
    pollTitle: string;
    deadline: number;
    option: Option[] = [];
    users: string;
}

export class Option {
    index: number;
    text: string;
    votes: number;
}