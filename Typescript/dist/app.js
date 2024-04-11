// https://jsonplaceholder.typicode.com/users/2
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
const getUserById = (id) => __awaiter(this, void 0, void 0, function* () {
    try {
        const fetchApi = yield fetch(`https://jsonplaceholder.typicode.com/users/${id}`);
        const resApi = yield fetchApi.json();
        console.log(resApi);
        return resApi;
    }
    catch (err) {
        console.log(err);
        throw new Error('Failed to fetch user');
    }
});
getUserById(5);
const getUsers = () => __awaiter(this, void 0, void 0, function* () {
    try {
        const fetchApi = yield fetch(`https://jsonplaceholder.typicode.com/users`);
        const resApi = yield fetchApi.json();
        console.log(resApi);
        return resApi;
    }
    catch (err) {
        console.log(err);
        throw new Error('Failed to fetch users');
    }
});
getUsers();
