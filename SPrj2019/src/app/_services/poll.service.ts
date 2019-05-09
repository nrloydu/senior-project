import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Poll, Option } from '../_models';
import { User } from '../_models';

@Injectable({ providedIn: 'root' })
export class PollService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Poll[]>(`/poll`);
    }

    getById(id: number) {
        return this.http.get(`/poll/${id}`);
    }

    create(poll: Poll) {
        return this.http.post(`/poll/new-poll`, poll);
    }

    update(poll: Poll) {
        return this.http.put(`/poll/${poll.id}`, poll);
    }

    delete(id: number) {
        return this.http.delete(`/poll/${id}`);
    }
}