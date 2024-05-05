

import UIKit

protocol FruitDetailPresenterProtocol: AnyObject {
    
    var wireframe: FruitDetailWireFrameProtocol? {get set}
    var view: FruitDetailViewProtocol? {get set}
    
    //View -> Presenter
    func viewDidLoad()
    func backButtonPressed(from view: UIViewController)
    
}

protocol FruitDetailViewProtocol: AnyObject {
    //Presenter -> View
    func showFruitDetail(with fruit: Fruit)
}

protocol FruitDetailWireFrameProtocol: AnyObject {
    func goBackToFruitListView(from view: UIViewController)
}
