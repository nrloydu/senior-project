export class Poll {
    id: number;
    ownerId: number;
    title: string;
    question: string;
    deadline: number;
    option: Option[] = [];
    voterIds: number[] = [];
}

export class Option {
    index: number;
    text: string;
    votes: number;
}