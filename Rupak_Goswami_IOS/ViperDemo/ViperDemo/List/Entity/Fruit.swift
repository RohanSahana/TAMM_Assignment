

import UIKit

struct Fruit {
    var name: String!
    var country: String!
    var stateprovince: String!
    var alphatwocode: String!
    
    init(attributes: [String: String]) {
        self.name = attributes["name"]
        self.country = attributes["country"]
        self.stateprovince = attributes["stateprovince"]
        self.alphatwocode = attributes["alphatwocode"]
    }
}
