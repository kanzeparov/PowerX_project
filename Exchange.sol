pragma solidity ^0.4.0;
contract Exchange {
    address owner;
    address seller;
    address buyer;
    
    bool active;

    uint256 price;
    
    mapping (address => uint256) Tokens;

    constructor (uint256 _price) public {
        seller = 0;
        buyer = 0;
        active = false;
        price=_price;
    }
    
    function Sell () public {
        seller = msg.sender;
    }
    
    function Buy () public {
        require(seller!=0);
        buyer = msg.sender;
        active=true;
    }
    
    function IsActive() public view returns (bool) {
        return active;
    }
    
    function AddDeposit (uint256 token) public payable //for test only
    {
        Tokens[msg.sender] += token;        
    }
    
    function Step() public
    {
        require (Tokens[buyer]>=price);
        require (active);
        Tokens[buyer] = Tokens[buyer]-price;
        Tokens[seller] = Tokens[seller]+price;

    }
    
    function Stop() public
    {
        active=false;
        buyer=0;
        seller=0;
    }
    
 
    
    function TokensSeller() public view returns (uint256) {
        return Tokens[seller];
    }
    
    function TokensBuyer() public view returns (uint256) {
        return Tokens[buyer];
    }
    
    function MyTokens() public view returns (uint256) {
        return Tokens[msg.sender];
    }
    
}
