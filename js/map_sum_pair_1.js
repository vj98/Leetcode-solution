var MapSum = function() {
    this.map = {};
};

MapSum.prototype.insert = function(key, val) {
    this.map[key] = val;
};

MapSum.prototype.sum = function(prefix) {
    return Object.keys(this.map)
        .filter(key=>key.startsWith(prefix))
        .map(key=>this.map[key])
        .reduce((total, curr)=>total+curr, 0);
};