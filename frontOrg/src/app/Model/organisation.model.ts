export class Organisation {
    constructor(
        public id?: number,
        public description?: String,
        public email?: String,
        public etat?: Boolean,
        public logo?: String,
        public mdp?: String,
        public nom?: String,
        public nomResp?: String,
        public prenomResp?: String,
        public tel?: number,
        public type?: String,
    ){}
}
