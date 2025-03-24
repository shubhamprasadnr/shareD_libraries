def cleanWorkspace() {
    sh """
        echo "Cleaning workspace..."
        rm -rf *
        echo "Workspace cleaned!"
    """
}

