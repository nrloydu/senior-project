import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Poll, Option } from '../_models/poll';
import { User } from '../_models';

@Injectable({ providedIn: 'root' })
export class PollService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Poll[]>(`/new-poll`);
    }

    getById(id: number) {
        return this.http.get(`/new-poll/${id}`);
    }

    create(poll: Poll) {
        return this.http.post(`/new-poll`, poll);
    }

    update(poll: Poll) {
        return this.http.put(`/new-poll/${poll.id}`, poll);
    }

    delete(id: number) {
        return this.http.delete(`/new-poll/${id}`);
    }
}