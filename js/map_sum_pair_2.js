var MapSum = function () {
    this.trie = {};
  };
  
  /** 
   * @param {string} key 
   * @param {number} val
   * @return {void}
   */
  MapSum.prototype.insert = function (key, val) {
    let t = this.trie;
    for (let i = 0; i < key.length; i++) {
      let char = key[i];
      if (!t[char]) {
          t[char] = {};
      }
      t = t[char];
    }
    t['value'] = val;
      console.log("node ", t);
    return null;
  };
  
  /** 
   * @param {string} prefix
   * @return {number}
   */
  MapSum.prototype.sum = function (prefix) {
    let node = this.trie
    for (let i = 0; i < prefix.length; i++) {
        let char = prefix[i];
        node = node[char];
        if (!node) {
            return 0;
        }
    }
    return dfs(node);
      
    function dfs(node) {
        let sum = 0;
        for (let k in node) {
        if (k === 'value') {
            sum += node[k];
        }
        else {
            sum += dfs(node[k]);
        }
      }
      return sum;
    }
  };