pragma solidity >= 0.4.27 <0.7.0;

contract Products_manager{
    address owner;
    struct product{
        uint256 barCode;
        string name;
        string origin;
        string quality;

        uint256 temp;
        uint256 humid;
        uint256 latitude;
        uint256 longitude;
    }
    mapping (address => product) public productMapping;
    function test() public pure returns (string memory)
    {
        return "Phuong";
    }
    function inputInfo(uint256 BarCode, string memory Name, string memory Origin, string memory Quality) public returns (address)
    {
         address uniqueID =  address(uint256(sha256(abi.encodePacked(msg.sender, now))));
         productMapping[uniqueID].barCode = BarCode;
         productMapping[uniqueID].name = Name;
         productMapping[uniqueID].origin = Origin;
         productMapping[uniqueID].quality = Quality;
         return uniqueID;
    }
    function update(address uniqueID, uint256 Temp, uint256 Humid, uint256 Latitude, uint256 Longtitude) public returns(string memory){
        productMapping[uniqueID].temp = Temp;
        productMapping[uniqueID].humid = Humid;
        productMapping[uniqueID].latitude = Latitude;
        productMapping[uniqueID].longitude = Longtitude;
        return "Product is updated";
    }
}